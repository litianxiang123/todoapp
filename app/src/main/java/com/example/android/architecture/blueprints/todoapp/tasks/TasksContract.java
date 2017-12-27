/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.tasks;

import android.support.annotation.NonNull;

import com.example.android.architecture.blueprints.todoapp.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.BaseView;
import com.example.android.architecture.blueprints.todoapp.data.Task;

import java.util.List;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface TasksContract {

    interface View extends BaseView<Presenter> {

        /**
         * 展示正在加载中的指示器
         *
         * @param active true 展示 false 不展示
         */
        void setLoadingIndicator(boolean active);

        /**
         * 展示列表中的Task
         *
         * @param tasks tasks
         */

        void showTasks(List<Task> tasks);

        /**
         * 展示添加任务界面,用于跳转至AddEditTaskActivity
         */

        void showAddTask();

        /**
         * 展示Task的详细信息,跳转至 TaskDetailActivity
         * @param taskId taskId
         */

        void showTaskDetailsUi(String taskId);

        /**
         * FilterType 被置为 completed 状态时回调
         */

        void showTaskMarkedComplete();

        /**
         * FilterType 被置为 Active 状态时的回调
         */

        void showTaskMarkedActive();

        /**
         * 清除FilterType为Completed状态的Task
         */

        void showCompletedTasksCleared();

        /**
         * 加载错误回调
         */

        void showLoadingTasksError();

        /**
         * 没有Task 时的回调
         */

        void showNoTasks();

        /**
         * 展示所有 FilterType 为 Active 的 Task 的回调
         */

        void showActiveFilterLabel();

        /**
         * 展示所有 FilterType 为 Completed 的Task的回调
         */

        void showCompletedFilterLabel();

        /**
         * 展示所有 FilterType的回调
         */

        void showAllFilterLabel();

        /**
         * 展示没有 FilterType为 Active 时的界面 回调
         */

        void showNoActiveTasks();

        /**
         * 展示没有 FilterType为 Completed 时的界面 回调
         */

        void showNoCompletedTasks();

        /**
         * 展示add一条Task成功后的 回调
         */

        void showSuccessfullySavedMessage();

        /**
         * 当前视图的活跃状态
         *
         * @return true active<p></p>false destroy
         */

        boolean isActive();

        /**
         * 展示 Toolbar上面的Menu的 选择 展示 FilterType 的popmenu
         */

        void showFilteringPopUpMenu();
    }

    interface Presenter extends BasePresenter {

        /**
         * 当一个Task成功添加进来时,返回到TasksFragment时的回调
         *
         * @param requestCode requestCode
         * @param resultCode  resultCode
         */

        void result(int requestCode, int resultCode);

        /**
         * 从 `Model` 层获取数据的回调
         *
         * @param forceUpdate 是否刷新
         */

        void loadTasks(boolean forceUpdate);

        /**
         * 添加新的 Task 的回调
         */

        void addNewTask();

        /**
         * 查看Task详情的回调
         *
         * @param requestedTask special task
         */

        void openTaskDetails(@NonNull Task requestedTask);

        /**
         * 列表Item的checkBox 从false到true时的回调
         *
         * @param completedTask special task
         */

        void completeTask(@NonNull Task completedTask);

        /**
         * 列表Item的checkBox 从true到false时的回调
         *
         * @param activeTask special task
         */

        void activateTask(@NonNull Task activeTask);

        /**
         * 清除FilterType为Completed状态的Task
         */

        void clearCompletedTasks();

        /**
         * 设置当前列表显示的 Task 的 type
         *
         * @param requestType {@link TasksFilterType}
         */

        void setFiltering(TasksFilterType requestType);

        /**
         * 拿到当前列表显示的 Task 的 type
         *
         * @return {@link TasksFilterType}
         */
        TasksFilterType getFiltering();
    }
}
