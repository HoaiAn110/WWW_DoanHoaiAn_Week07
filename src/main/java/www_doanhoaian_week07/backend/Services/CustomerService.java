package www_doanhoaian_week07.backend.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import www_doanhoaian_week07.backend.models.Customer;
import www_doanhoaian_week07.backend.repositories.CustomerRepository;
import www_doanhoaian_week07.backend.utils.PageRender;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Page<Customer> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        return customerRepository.findAll(pageable);
    }

    public Page<Customer> findPaginated(Pageable pageable, Optional<String> keyword) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Customer> customers;
        if (keyword.isPresent()) {
            customers = customerRepository.findByKeyword(keyword.get());
        } else {
            customers = customerRepository.findAll();
        }
        PageRender<Customer> customerPageRender = new PageRender<>();
        List<Customer> list = customerPageRender.getPageOfModel(customers.size(),startItem,pageSize,customers);
        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), customers.size());
    }


}
