package model;

/**
 *
 * @author ACER
 */
public class BranchModel {

    private int branchId;
    private String branchCity;
    private float assets;

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchCity() {
        return branchCity;
    }

    public void setBranchCity(String branchCity) {
        this.branchCity = branchCity;
    }

    public float getAssets() {
        return assets;
    }

    public void setAssets(float assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "Branch{" + "branchId=" + branchId + ", branchCity=" + branchCity + ", assets=" + assets + '}';
    }
    
}
