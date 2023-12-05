package dao;

import java.util.List;
import model.CustomerModel;

/**
 *
 * @author ACER
 */
public interface ICustomerDao extends GenericDAO<CustomerModel> {

    CustomerModel findByCustomerID(String customer_id);

    Long save(CustomerModel newCustomer);

    void update(CustomerModel customer);

    List<CustomerModel> findAllCustomer ();

    String findLastCustomerID();

}
