package com.example.week3project.Service;

import com.example.week3project.Model.Merchant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantService {
    ArrayList<Merchant> Merchants = new ArrayList<>();

    public ArrayList<Merchant> getMerchants(){
        return Merchants;
    }

    public void addMerchant(Merchant Merchant){
        Merchants.add(Merchant);
    }

    public boolean updateMerchant(int id, Merchant Merchant){
        for (int i=0;i<Merchants.size();i++){
            if (Merchants.get(i).getId() == id){
                Merchants.set(i,Merchant);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMerchant(int id){
        for (int i=0;i<Merchants.size();i++){
            if (Merchants.get(i).getId() == i){
                Merchants.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkMerchantId(int id){
        for (int i=0;i<Merchants.size();i++){
            if (Merchants.get(i).getId() == id)
                return true;
        }
        return false;
    }
}
