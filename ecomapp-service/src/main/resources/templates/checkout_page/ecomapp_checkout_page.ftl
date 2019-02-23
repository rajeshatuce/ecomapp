<#import "../common/ecomapp_page.ftl" as page>
<#import "../common/ecomapp_top_header.ftl" as top_header>
<#import "ecomapp_product_payment_section.ftl" as product_payment>
<#import "../common/ecomapp_sub_footer_section.ftl" as sub_footer_section>
<#import "../common/ecomapp_footer.ftl" as footer>
<#import "ecomapp_add_new_address_modal.ftl" as add_new_address_modal>
<@page.ecomapp_page>

<!-- !PAGE CONTENT! -->
<div class="w3-main">
  <!-- Top header -->
  <@top_header.ecomapp_top_header/>

  <!-- product grid, address, payment section-->
  <@product_payment.ecomapp_product_payment_section/>
  <!-- Sub Footer -->
  <@sub_footer_section.ecomapp_sub_footer_section/>
  <!-- Footer -->
  <@footer.ecomapp_footer/>
  <!-- End page content -->
</div>
<!-- Add New Address Modal -->
  <@add_new_address_modal.ecomapp_add_new_address_modal/>
</@page.ecomapp_page>