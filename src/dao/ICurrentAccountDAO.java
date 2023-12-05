package dao;

import model.CurrentAccountModel;

/**
 *
 * @author ACER
 */
public interface ICurrentAccountDAO extends GenericDAO<CurrentAccountModel>{

    String saveCurrentAcount(CurrentAccountModel currentAccountMode, String id);

}
