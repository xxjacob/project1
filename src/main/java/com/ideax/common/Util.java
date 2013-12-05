package com.ideax.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

    public static ObjectMapper mapper = new ObjectMapper();
    public static JsonNode towns = null;
    public static JsonNode citys = null;
    public static JsonNode provinces = null;
    static {
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
        try {
            towns = mapper.readTree(Util.class.getResourceAsStream("/city/town.txt"));
            citys = mapper.readTree(Util.class.getResourceAsStream("/city/city.txt"));
            provinces = mapper.readTree(Util.class.getResourceAsStream("/city/province.txt"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return [ { "name":"明光市", "id":1161 }, { "name":"定远县", "id":1164 }]
     */
    public static JsonNode getCity(String cid) {
        return towns.get(cid);
    }

    /**
     * getProviceidByName
     * 
     * @param pname
     * @return
     */
    public static int getProviceidByName(String pname) {
        Iterator<Entry<String, JsonNode>> fields = provinces.fields();
        Entry<String, JsonNode> en = null;
        for (; (en = fields.next()) != null;) {
            if (en.getKey().equals(pname)) {
                return en.getValue().get("id").asInt();
            }
        }
        return 0;
    }

    /**
     * getCityidByName
     * 
     * @param pname
     * @return
     */
    public static int getCityidByName(int provinceid, String cname) {
        JsonNode node = citys.get(provinceid + "");
        for (JsonNode en : node) {
            if (en.get("name").asText().contains(cname)) {
                return en.get("id").asInt();
            }
        }
        return 0;
    }

    /**
     * 组成唯一地区id
     * 
     * @param proviceid
     * @param cityid
     * @param townid
     * @return
     */
    public static long getRegionid(int provinceid, int cityid, int townid) {
        return provinceid * 1000000000000L + cityid * 1000000L + townid;
    }

    public static long[] splitRegionid(long regionid) {
        long[] ret = new long[3];
        ret[0] = regionid / 1000000000000L;
        ret[1] = (regionid / 1000000L) % 1000000;
        ret[2] = regionid % 1000000L;
        return ret;
    }
}
