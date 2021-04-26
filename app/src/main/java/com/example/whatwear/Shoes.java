package com.example.whatwear;

import java.util.HashMap;

public class Shoes
{
    public String result[];
    Shoes(int res)
    {
        class dict {
            HashMap<Integer, String[]> shoesdict = new HashMap<>();

            dict(int res)
            {
                shoesdict.put(0,new String[] {"БотинкиМЗ","БотинкиЖЗ"});
                shoesdict.put(1,new String[]{"БотинкиД","КроссовкиД","Кеды","СапогиМЗ","ТуфлиМЗ","БотинкиЖ","Казаки"});
                shoesdict.put(2,new String[]{"КроссовкиМД","КедыМД","ТуфлиМ","СапогиМД","Ботильоны","БотинкиЖ","Казаки","КроссовкиЖД","КедыЖД","СапогиЖД","ТуфлиЖД"});
                shoesdict.put(3,new String[]{"КроссовкиМ","КедыМ","ТуфлиМ","СапогиМД","Ботильоны","Казаки","КроссовкиЖ","КедыЖ"});
                shoesdict.put(4,new String[]{"КроссовкиМ","КедыМ","ТуфлиМ","СлипоныМ","МокасиныМ","ТопсайдерыМ","ЭскадрильиМ","ТуфлиЖ","Босоножки","Балетки","Балетки","СандалииЖ","Топсайдерыж","МокасиныЖ","СабоЖ","МюлиЖ","СлипоныЖ","КроссовкиЖ","КедыЖ"});
                shoesdict.put(5,new String[]{"КроссовкиМ","КедыМ","ТуфлиМ","СандалииМ","ТапочкиМ","МокасиныМ","ТопсайдерыМ","ЭскадрильиМ","ТуфлиЖ","Босоножки","Балетки","СандалииЖ","ТопсайдерыЖ","МокасиныЖ","СабоЖ","МюлиЖ","СлипоныЖ","КроссовкиЖ","КедыЖ"});
                if (res==5)
                {
                    result=shoesdict.get(5);
                }
                else if( res==4)
                {
                    result=shoesdict.get(4);
                }
                else if (res==3)
                {
                    result=shoesdict.get(3);
                }
                else if(res==2)
                {
                    result=shoesdict.get(2);
                }
                else if( res==1)
                {
                    result=shoesdict.get(1);
                }
                else if(res==0)
                {

                    result=shoesdict.get(0);
                }
            }

        }
    }
   public String[] GetResult()
  {

      return result;
  }
}
