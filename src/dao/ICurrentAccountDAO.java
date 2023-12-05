package dao;

import model.CurrentAccountModel;

/**
 *
 * @author ACER
 */
public interface ICurrentAccountDAO extends GenericDAO<CurrentAccountModel>{

    String savingCurrentAcount(CurrentAccountModel currentAccountModel, String interestRate, String id);

}
