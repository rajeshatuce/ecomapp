package com.rt.util;

import static com.rt.constant.EComAppConstant.CURRENCY_FORMAT_STRING;
import static com.rt.constant.EComAppConstant.EMAIL;

import com.rt.model.Product;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

@Component
public class EcomAppServiceUtil {

  public String getEmailIdFromPrincipalObject(Principal principal) {
    OAuth2Authentication auth = (OAuth2Authentication) principal;
    LinkedHashMap<String, String> details = (LinkedHashMap<String, String>) auth
        .getUserAuthentication().getDetails();
    return details.get(EMAIL);
  }

  public Map<String, List<Product>> groupSimilarProductTogether(List<Product> products) {
    Map<String, List<Product>> result = new HashMap<>();
    for (Product product : products) {
      List<Product> temp = result.getOrDefault(product.getProductGroup(), new ArrayList<Product>());
      temp.add(product);
      result.put(product.getProductGroup(), temp);
    }
    return result;
  }

  public double roundToTwoDecimalPlaces(double amount) {
    return Math.round(amount * 100.0) / 100.0;
  }

  public String formatAmount(double amount) {
    return String.format(CURRENCY_FORMAT_STRING, amount);
  }


}
