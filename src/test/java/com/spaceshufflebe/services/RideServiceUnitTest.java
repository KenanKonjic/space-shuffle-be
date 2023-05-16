package com.spaceshufflebe.services;

import com.spaceshufflebe.data.RideTest;
import com.spaceshufflebe.models.RideDto;
import com.spaceshufflebe.models.entities.RideEntity;
import com.spaceshufflebe.repositories.RideRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
class RideServiceUnitTest {
    @MockBean
    private RideRepository repository;

    @TestConfiguration
    static class RideServiceTestConfiguration {

        @Bean
        @Primary
        public RideService rideService(RideRepository repository) {
            return new RideService(repository);
        }
    }

    @Autowired
    private RideService rideService;

    private static Time time2 = new Time(10);


    @Test
    void givenRideDto_whenCreateRide_thenRideReturned() throws Exception {
        // Arrange
        RideDto rideDto = RideTest.rideDto1();
        rideDto.setStartingLocation("Start");
        rideDto.setEndLocation("End");
        rideDto.setAvailableSeats(3);
        rideDto.setTime(time2);

        RideEntity expectedRideEntity = new RideEntity();
        expectedRideEntity.setStartingLocation("Start");
        expectedRideEntity.setEndLocation("End");
        expectedRideEntity.setAvailableSeats(3);
        rideDto.setTime(time2);

        Mockito.when(repository.save(any(RideEntity.class))).thenReturn(expectedRideEntity);

        // Act
        RideEntity createdRide = rideService.createRide(rideDto);

        // Assert
        verify(repository, times(1)).save(any(RideEntity.class));
        Assertions.assertEquals(expectedRideEntity, createdRide);
    }

    @Test
    void givenEmptyDatabase_whenGetRides_thenEmptyListReturned() {
        // Arrange
        List<RideEntity> emptyRideEntities = new ArrayList<>();
        Mockito.when(repository.findAll()).thenReturn(emptyRideEntities);

        // Act
        List<RideEntity> retrievedRides = rideService.getRides();

        // Assert
        verify(repository, times(1)).findAll();
        Assertions.assertEquals(emptyRideEntities, retrievedRides);
    }

    @Test
    void givenNonEmptyDatabase_whenGetRides_thenListOfRidesReturned() {
        // Arrange
        List<RideEntity> rideEntities = new ArrayList<>();
        rideEntities.add(new RideEntity());
        rideEntities.add(new RideEntity());
        Mockito.when(repository.findAll()).thenReturn(rideEntities);

        // Act
        List<RideEntity> retrievedRides = rideService.getRides();

        // Assert
        verify(repository, times(1)).findAll();
        Assertions.assertEquals(rideEntities, retrievedRides);
    }

    @Test
    void givenRideDto_whenReturnEntity_thenRideEntityReturned() throws Exception {
        // Arrange
        RideDto rideDto = RideTest.rideDto4();
        rideDto.setStartingLocation("Start");
        rideDto.setEndLocation("End");
        rideDto.setAvailableSeats(3);
        rideDto.setTime(time2);

        // Act
        RideEntity rideEntity = rideService.ReturnEntity(rideDto);

        // Assert
        Assertions.assertEquals(rideDto.getStartingLocation(), rideEntity.getStartingLocation());
        Assertions.assertEquals(rideDto.getEndLocation(), rideEntity.getEndLocation());
        Assertions.assertEquals(rideDto.getAvailableSeats(), rideEntity.getAvailableSeats());
    }

    @Test
    public void givenRide_whenDelete_thenRepositoryCalled() {
        // arrange
        Integer id = 1;

        // act
        rideService.deleteRide(id);

        // assert
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void givenIdAndRideDto_whenUpdateRide_thenRideDtoReturned() throws Exception {
        // Arrange
        Integer id = 1;
        RideDto rideDto = RideTest.rideDto1();
        rideDto.setStartingLocation("End");
        rideDto.setEndLocation("Start");
        rideDto.setAvailableSeats(4);
        rideDto.setTime(time2);

        RideEntity existingEntity = new RideEntity();
        existingEntity.setId(id);
        existingEntity.setStartingLocation("Old Start");
        existingEntity.setEndLocation("Old End");
        existingEntity.setAvailableSeats(5);
        rideDto.setTime(time2);

        RideEntity updatedEntity = new RideEntity();
        updatedEntity.setId(id);
        updatedEntity.setStartingLocation("Start");
        updatedEntity.setEndLocation("End");
        updatedEntity.setAvailableSeats(3);
        rideDto.setTime(time2);

        Mockito.when(repository.save(any(RideEntity.class))).thenReturn(updatedEntity);
        Mockito.when(repository.findById(id)).thenReturn(java.util.Optional.of(existingEntity));

        // Act
        RideDto updatedRideDto = rideService.updateRide(id, rideDto);

        // Assert
        verify(repository, times(1)).findById(id);
        verify(repository, times(1)).save(any(RideEntity.class));
        Assertions.assertEquals(updatedEntity.getId(), updatedRideDto.getId());
        Assertions.assertEquals(updatedEntity.getStartingLocation(), updatedRideDto.getStartingLocation());
        Assertions.assertEquals(updatedEntity.getEndLocation(), updatedRideDto.getEndLocation());
        Assertions.assertEquals(updatedEntity.getAvailableSeats(), updatedRideDto.getAvailableSeats());
        Assertions.assertEquals(updatedEntity.getTime(), updatedRideDto.getTime());
    }

//    @Test
//    void givenRideEntity_whenToDto_thenRideDtoReturned() {
//        // Arrange
//        RideEntity rideEntity = new RideEntity();
//        rideEntity.setId(1);
//        rideEntity.setStartingLocation("Start");
//        rideEntity.setEndLocation("End");
//        rideEntity.setAvailableSeats(3);
//        rideEntity.setTime(time2);
//
//        // Act
//        RideDto rideDto = rideService.toDto(rideEntity);
//
//        // Assert
//        Assertions.assertEquals(rideEntity.getId(), rideDto.getId());
//        Assertions.assertEquals(rideEntity.getStartingLocation(), rideDto.getStartingLocation());
//        Assertions.assertEquals(rideEntity.getEndLocation(), rideDto.getEndLocation());
//        Assertions.assertEquals(rideEntity.getAvailableSeats(), rideDto.getAvailableSeats());
//        Assertions.assertEquals(rideEntity.getTime(), rideDto.getTime());
//    }
//
//    @Test
//    void givenExistingId_whenGetEntity_thenRideEntityReturned() {
//        // Arrange
//        Integer id = 1;
//        RideEntity expectedRideEntity = new RideEntity();
//        expectedRideEntity.setId(id);
//
//        Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedRideEntity));
//
//        // Act
//        RideEntity rideEntity = rideService.getEntity(id);
//
//        // Assert
//        verify(repository, times(1)).findById(id);
//        Assertions.assertEquals(expectedRideEntity, rideEntity);
//    }
//
//    @Test
//    void givenNonExistingId_whenGetEntity_thenExceptionThrown() {
//        // Arrange
//        Integer id = 1;
//
//        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());
//
//        // Act & Assert
//        Assertions.assertThrows(RuntimeException.class, () -> rideService.getEntity(id));
//        verify(repository, times(1)).findById(id);
//    }
}
