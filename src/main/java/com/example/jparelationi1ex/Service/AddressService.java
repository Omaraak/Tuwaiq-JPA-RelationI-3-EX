package com.example.jparelationi1ex.Service;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.DTO.AddressDTO;
import com.example.jparelationi1ex.Model.Address;
import com.example.jparelationi1ex.Model.Teacher;
import com.example.jparelationi1ex.Repository.AddressRepository;
import com.example.jparelationi1ex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public void addAddressToTeacher(AddressDTO addressDTO) throws ApiException {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Address addressToAdd = new Address(addressDTO.getTeacher_id(), addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(addressToAdd);
    }

    public void updateAddressToTeacher(AddressDTO addressDTO) throws ApiException {
        Address addressToUpdate = addressRepository.findAddressById(addressDTO.getTeacher_id());
        if (addressToUpdate == null) {
            throw new ApiException("Address not found");
        }
        addressToUpdate.setArea(addressDTO.getArea());
        addressToUpdate.setStreet(addressDTO.getStreet());
        addressToUpdate.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(addressToUpdate);
    }

    public void deleteAddressFromTeacher(int addressID) throws ApiException {
        Address a = addressRepository.findAddressById(addressID);
        if (a == null){
            throw new ApiException("Address not found");
        }
        addressRepository.delete(a);
    }
}
