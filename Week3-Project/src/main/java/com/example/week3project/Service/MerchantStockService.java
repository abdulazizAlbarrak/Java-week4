package com.example.week3project.Service;

import com.example.week3project.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> MerchantStocks = new ArrayList<>();

    public ArrayList<MerchantStock> getMerchantStocks(){
        return MerchantStocks;
    }

    public void addMerchantStock(MerchantStock MerchantStock){
        MerchantStocks.add(MerchantStock);
    }

    public boolean updateMerchantStock(int id, MerchantStock MerchantStock){
        for (int i=0;i<MerchantStocks.size();i++){
            if (MerchantStocks.get(i).getId() == id){
                MerchantStocks.set(i,MerchantStock);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchantStock(int id){
        for (int i=0;i<MerchantStocks.size();i++){
            if (MerchantStocks.get(i).getId() == i){
                MerchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean addStock(int merchantId, int productId, int stock){
        for (int i=0;i<MerchantStocks.size();i++){
            if (MerchantStocks.get(i).getProductId() == productId && MerchantStocks.get(i).getMerchantId() == merchantId){
                MerchantStocks.get(i).setStock(MerchantStocks.get(i).getStock()+stock);
                return true;
            }
        }
        return false;
    }


    public boolean checkStock(int id){
        for (int i=0;i<MerchantStocks.size();i++){
            if (MerchantStocks.get(i).getMerchantId() == id) {
                if (MerchantStocks.get(i).getStock() > 0) {
                    MerchantStocks.get(i).setStock(MerchantStocks.get(i).getStock() - 1);
                    return true;
                }
            }
        }
        return false;
    }


}
