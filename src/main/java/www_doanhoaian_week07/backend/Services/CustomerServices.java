package www_doanhoaian_week07.backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.models.Customer;
import www_doanhoaian_week07.backend.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setEmail(updatedCustomer.getEmail());
                    // Set other properties as needed
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new IllegalArgumentException("Customer not found."));
    }
}
