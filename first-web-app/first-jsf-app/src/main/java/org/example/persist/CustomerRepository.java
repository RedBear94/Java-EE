package org.example.persist;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
@Named
public class CustomerRepository {
    private final Map<Long, Customer> customerMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init() {
        save(new Customer(null, "Customer name 1", "Customer surname 1", "Address 1","+7 991 888 77 66"));
        save(new Customer(null, "Customer name 2", "Customer surname 2", "Address 2","+7 992 888 77 66"));
        save(new Customer(null, "Customer name 3", "Customer surname 3", "Address 3","+7 993 888 77 66"));
        save(new Customer(null, "Customer name 4", "Customer surname 4", "Address 4","+7 994 888 77 66"));
    }

    public void save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(identity.incrementAndGet());
        }
        customerMap.put(customer.getId(), customer);
    }

    public void delete(Long id) {
        customerMap.remove(id);
    }

    public Customer findById(Long id) {
        return customerMap.get(id);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }
}
