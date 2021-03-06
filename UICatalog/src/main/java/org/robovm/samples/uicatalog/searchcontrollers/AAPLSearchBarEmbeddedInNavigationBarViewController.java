/*
 * Copyright (C) 2013-2015 RoboVM AB
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 * Portions of this code is based on Apple Inc's UICatalog sample (v11.3)
 * which is copyright (C) 2008-2015 Apple Inc.
 */
package org.robovm.samples.uicatalog.searchcontrollers;

import org.robovm.apple.uikit.UISearchBarStyle;
import org.robovm.apple.uikit.UISearchController;
import org.robovm.objc.annotation.CustomClass;

@CustomClass("AAPLSearchBarEmbeddedInNavigationBarViewController")
public class AAPLSearchBarEmbeddedInNavigationBarViewController extends AAPLSearchControllerBaseViewController {
    private UISearchController searchController;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        // Create the search results view controller and use it for the
        // UISearchController.
        AAPLSearchResultsViewController searchResultsController = (AAPLSearchResultsViewController) getStoryboard()
                .instantiateViewController(
                        AAPLSearchResultsViewController.STORYBOARD_IDENTIFIER);

        // Create the search controller and make it perform the results
        // updating.
        searchController = new UISearchController(searchResultsController);
        searchController.setSearchResultsUpdater(searchResultsController);
        searchController.setHidesNavigationBarDuringPresentation(false);

        // Configure the search controller's search bar. For more information on
        // how to configure
        // search bars, see the "Search Bar" group under "Search".
        searchController.getSearchBar().setSearchBarStyle(UISearchBarStyle.Minimal);
        searchController.getSearchBar().setPlaceholder("Search");

        // Include the search bar within the navigation bar.
        getNavigationItem().setTitleView(searchController.getSearchBar());

        setDefinesPresentationContext(true);
    }
}
