package com.example.jparelationi1ex.Controller;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.DTO.AddressDTO;
import com.example.jparelationi1ex.Model.Address;
import com.example.jparelationi1ex.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/getAllAddresses")
    public ResponseEntity<List<Address>> getAllAddresses() {
        return ResponseEntity.status(200).body(addressService.getAllAddresses());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO address) throws ApiException {
        addressService.addAddressToTeacher(address);
        return ResponseEntity.status(200).body("address added successfully");
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO address) throws ApiException {
        addressService.updateAddressToTeacher(address);
        return ResponseEntity.status(200).body("address updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable int id) throws ApiException {
        addressService.deleteAddressFromTeacher(id);
        return ResponseEntity.status(200).body("address deleted successfully");
    }
}
