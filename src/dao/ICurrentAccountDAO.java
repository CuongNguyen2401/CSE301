package dao;

import java.util.List;
import model.CurrentAccountModel;

/**
 *
 * @author ACER
 */
public interface ICurrentAccountDAO extends GenericDAO<CurrentAccountModel> {

    String saveCurrentAcount(CurrentAccountModel currentAccountMode, String id);

    List<CurrentAccountModel> findAllCurrentAccount();
    
    CurrentAccountModel findCurrentAccountModelByID(String id);
    
}
