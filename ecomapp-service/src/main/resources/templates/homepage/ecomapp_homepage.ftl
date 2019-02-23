<#import "../common/ecomapp_page.ftl" as page>
<#import "ecomapp_product_details_modal.ftl" as product_details>
<#import "../common/ecomapp_top_header.ftl" as top_header>
<#import "ecomapp_image_header.ftl" as image_header>
<#import "ecomapp_product_section.ftl" as product_section>
<#import "ecomapp_subscribe_section.ftl" as subscribe_section>
<#import "../common/ecomapp_sub_footer_section.ftl" as sub_footer_section>
<#import "../common/ecomapp_footer.ftl" as footer>

<@page.ecomapp_page>

<!-- !PAGE CONTENT! -->
<div class="w3-main">
  <!-- Top header -->
  <@top_header.ecomapp_top_header/>

  <!-- Image header -->
  <@image_header.ecomapp_image_header/>
  <!-- Product section -->
  <@product_section.ecomapp_product_section/>
  <!-- Subscribe section -->
  <@subscribe_section.ecomapp_subscribe_section/>

  <!-- Sub Footer -->
  <@sub_footer_section.ecomapp_sub_footer_section/>
  <!-- Footer -->
  <@footer.ecomapp_footer/>
  <!-- End page content -->
</div>

<!-- Product Details Modal -->
  <@product_details.product_details_modal/>
</@page.ecomapp_page>