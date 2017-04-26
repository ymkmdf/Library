package com.meipan.library._ui.dataview;

import com.meipan.library.api.model.Model;

/**
 * Created by gaoyan on 17/2/25.
 */

public interface MainView extends BaseView {
    void getDataSuccess(Model model);
    void getDataFail(String str);
}
