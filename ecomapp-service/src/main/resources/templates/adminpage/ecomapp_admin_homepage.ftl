<#import "../common/ecomapp_admin_page.ftl" as adminpage>
<#import "../common/ecomapp_admin_top_header.ftl" as admin_top_header>
<#import "ecomapp_admin_body.ftl" as admin_body>
<#import "../common/ecomapp_footer.ftl" as footer>

<@adminpage.ecomapp_admin_page>

<!-- !PAGE CONTENT! -->
<div class="w3-main">
  <!-- Top header -->
  <@admin_top_header.ecomapp_admin_top_header/>
  <!-- Admin Body -->
  <@admin_body.ecomapp_admin_body/>
  <!-- footer -->
  <@footer.ecomapp_footer/>
  <!-- End page content -->
</div>
</@adminpage.ecomapp_admin_page>