package com.example.whatwear;

import java.util.HashMap;
import java.util.Map;

    public class Outerwear {
        String[] result;

        public Outerwear(int res) {
        }

        public class dict {

            HashMap<Integer, String[]> dictionary = new HashMap<>();

            dict(int res)
            {
                dictionary.put(0,new String[] {"пуховик","горонлыжная куртка","шуба"});
                dictionary.put(1,new String[]{"кожанная куртка","пуховик","горнолыжная куртка"});
                dictionary.put(2,new String[]{"жилетка","пальто"});
                dictionary.put(3,new String[]{"косуха","пальто","пончо"});
                dictionary.put(4,new String[]{"косуха","кардиган","ветровка"});
                dictionary.put(5,new String[]{"слишком жарко для куртки"});
                if (res==5)
                {
                    result=dictionary.get(5);
                }
                else if( res==4)
                {
                    result=dictionary.get(4);
                }
                else if (res==3)
                {
                    result=dictionary.get(3);
                }
                else if(res==2)
                {
                    result=dictionary.get(2);
                }
                else if( res==1)
                {
                    result=dictionary.get(1);
                }
                else if(res==0)
                {

                    result=dictionary.get(0);
                }

            }

        }
        public String[] GetResult()
        {

            return result;
        }

    }

