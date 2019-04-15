<#macro ecomapp_setting_productGroup>
   <div class="w3-container">
     <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
       <div class="w3-container w3-brown">
         <h6>Product Group</h6>
       </div>
       <div class="w3-responsive w3-margin-top" data-ng-init="fetchAllProductGroup()">
         <table class="w3-table-all w3-centered">
           <thead>
           <tr class="w3-brown">
             <th>ID</th>
             <th>PRODUCT GROUP</th>
             <th>STATUS</th>
             <th>CREATE DATE</th>
             <th>CREATED BY</th>
             <th>MODIFIED DATE</th>
             <th>MODIFIED BY</th>
             <th></th>
           </tr>
           </thead>
           <tr ng-repeat="pg in productGroupSetting track by $index">
             <td>{{pg.id}}</td>
             <td>{{pg.productGroup}}</td>
             <td>{{pg.status}}</td>
             <td>{{pg.createDateFormatted}}</td>
             <td>{{pg.createdBy}}</td>
             <td>{{pg.modifiedDateFormatted}}</td>
             <td>{{pg.modifiedBy}}</td>
             <td>
               <button
                   class="w3-button w3-tiny w3-hover-green w3-pale-yellow w3-border w3-border-red w3-round-large w3-ripple fa fa-edit"
                   ng-click="editProductGroupFns(pg.id)">EDIT
               </button>
             </td>
           </tr>
         </table>
       </div>
       <form action="#" method="post" name="saveProductGroupForm" novalidate>
         <div class="w3-card-4 w3-padding ecomapp-margin-top-28px w3-margin-bottom">
           <div class="w3-container w3-brown">
             <h6>Product Group Form</h6>
           </div>
           <p>
             <label class="w3-text-brown"><b>ID:</b>{{editProductGroup.id}}</label>
           </p>
           <p>
             <label class="w3-text-brown"><b>Product Group*</b></label>
             <input class="w3-input w3-border" name="productGroup" type="text"
                    ng-model="editProductGroup.productGroup" required>
           </p>
           <p>
             <label class="w3-text-brown"><b>Status*</b></label>
             <select class="w3-select" name="status" ng-model="editProductGroup.status" required>
               <option value="Active">Active</option>
               <option value="Inactive">Inactive</option>
             </select>
           </p>
         </div>
         <div class="w3-center w3-margin">
           <button class="w3-btn w3-white w3-border w3-round-xxlarge w3-ripple"
                   ng-click="resetProductGroupForm($event)">
             Reset
           </button>
           <button
               class="w3-btn w3-round-xxlarge w3-red w3-hover-green w3-ripple fa fa-thumbs-up"
               ng-disabled="saveProductGroupForm.$invalid" ng-click="saveProductGroup($event)">Save
             Details
           </button>
         </div>
       </form>
     </div>
   </div>
</#macro>