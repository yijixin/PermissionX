package com.yjx.permissionx.permission_library.single

import androidx.fragment.app.FragmentActivity
import com.yjx.permissionx.permission_library.InvisibleFragment
import com.yjx.permissionx.permission_library.PermissionCallBack

/**
 * @author yijixin on 2020/7/28
 */
object PermissionX {

    private const val TAG = "InvisibleFragment"

    fun request(activity : FragmentActivity, vararg permissions : String,
                callback : PermissionCallBack) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragment != null) {
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}