package com.example.whatwear;

import java.util.HashMap;

public class Tshirt
{
    public String[] result;
    Tshirt(int res)
    {
        HashMap<Integer,String[]> tshirt= new HashMap<>();
        tshirt.put(4,new String[]{"ЛонгсливM","ФутболкаM","ПолоM","Спортивная футболкаМ","ЛонгсливЖ","ФутболкаЖ","ПолоЖ","Спортивная футболкаЖ"});
        tshirt.put(5,new String[]{"ЛонгсливM","ФутболкаM","ПолоM","Спортивная футболкаМ","ЛонгсливЖ","ФутболкаЖ","ПолоЖ","Спортивная футболкаЖ"});
        if (res==5)
        {
            result=tshirt.get(5);
        }
        else if( res==4)
        {
            result=tshirt.get(4);
        }
    }
     public String[] GetResult()
     {
         return result;
     }
}
