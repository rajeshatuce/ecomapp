<#import "../common/ecomapp_page.ftl" as page>
<#import "../common/ecomapp_top_header.ftl" as top_header>
<#import "../common/ecomapp_sub_footer_section.ftl" as sub_footer_section>
<#import "../common/ecomapp_footer.ftl" as footer>
<#import "ecomapp_orders_table.ftl" as orders>
<@page.ecomapp_page>

<!-- !PAGE CONTENT! -->
<div class="w3-main">
  <!-- Top header -->
  <@top_header.ecomapp_top_header/>
  <!-- My Orders Table -->
  <@orders.ecomapp_orders_table/>

  <!-- Sub Footer -->
  <@sub_footer_section.ecomapp_sub_footer_section/>
  <!-- Footer -->
  <@footer.ecomapp_footer/>
  <!-- End page content -->
</div>
</@page.ecomapp_page>