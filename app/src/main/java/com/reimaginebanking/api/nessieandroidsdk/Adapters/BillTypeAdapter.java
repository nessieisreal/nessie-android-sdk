package com.reimaginebanking.api.nessieandroidsdk.Adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import com.reimaginebanking.api.nessieandroidsdk.Constants.BillStatus;
import com.reimaginebanking.api.nessieandroidsdk.models.Bill;

import java.io.IOException;

/**
 * Created by hxp347 on 5/8/15.
 */
public class BillTypeAdapter extends TypeAdapter<Bill> {


    @Override
    public void write(JsonWriter out, Bill bill) throws IOException {
        out.beginObject();
        out.name("_id").value(bill.get_id());
        if(bill.getStatus() != null)
            out.name("status").value(bill.getStatus().toString());
        out.name("payee").value(bill.getPayee());
        out.name("nickname").value(bill.getNickname());
        out.name("creation_date").value(bill.getCreation_date());
        out.name("payment_date").value(bill.getPayment_date());
        if(bill.getRecurring_date() != 0)
            out.name("recurring_date").value(bill.getRecurring_date());
        out.name("upcoming_payment_date").value(bill.getUpcoming_payment_date());
        if(bill.getPayment_amount() != 0)
            out.name("payment_amount").value(bill.getPayment_amount());
        out.endObject();
    }

    @Override
    public Bill read(JsonReader in) throws IOException {
        String status;

        final Bill bill = new Bill();

        in.beginObject();
        while(in.hasNext()){
            switch (in.nextName()){
                case "_id":
                    bill.set_id(in.nextString());
                    break;
                case "status":
                    status = in.nextString();
                    BillStatus billStatus = null;

                    if(status == BillStatus.PENDING.toString()){
                        billStatus = BillStatus.PENDING;
                    }else if(status == BillStatus.CANCELLED.toString()){
                        billStatus = BillStatus.CANCELLED;
                    }else if(status == BillStatus.COMPLETED.toString()){
                        billStatus = BillStatus.COMPLETED;
                    }else if(status == BillStatus.RECURRING.toString()){
                        billStatus = BillStatus.RECURRING;
                    }
                    bill.setStatus(billStatus);
                    break;
                case "payee":
                    bill.setPayee(in.nextString());
                    break;
                case "nickname":
                    bill.setNickname(in.nextString());
                    break;
                case "creation_date":
                    bill.setCreation_date(in.nextString());
                    break;
                case "payment_date":
                    bill.setPayment_date(in.nextString());
                    break;
                case "recurring_date":
                    bill.setRecurring_date(Integer.parseInt(in.nextString()));
                    break;
                case "upcoming_payment_date":
                    bill.setUpcoming_payment_date(in.nextString());
                    break;
                case "payment_amount":
                    bill.setPayment_amount(Double.parseDouble(in.nextString()));
                    break;
            }
        }
        in.endObject();

        return bill;
    }
}
