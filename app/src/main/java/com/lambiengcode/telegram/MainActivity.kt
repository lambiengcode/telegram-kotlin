package com.lambiengcode.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import com.lambiengcode.telegram.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mDrawer: Drawer
    private lateinit var mHeader: AccountHeader
    private lateinit var mToolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        setSupportActionBar(mToolbar)
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDrawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .withActionBarDrawerToggle(true)
                .withSelectedItem(-1)
                .withAccountHeader(mHeader)
                .addDrawerItems(
                        PrimaryDrawerItem().withIdentifier(100)
                                .withIconTintingEnabled(true)
                                .withName("Create Group")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_groups),
                        PrimaryDrawerItem().withIdentifier(101)
                                .withIconTintingEnabled(true)
                                .withName("Secret Chat")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_secret_chat),
                        PrimaryDrawerItem().withIdentifier(102)
                                .withIconTintingEnabled(true)
                                .withName("Create Channel")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_channel),
                        PrimaryDrawerItem().withIdentifier(103)
                                .withIconTintingEnabled(true)
                                .withName("Contacts")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_contacts),
                        PrimaryDrawerItem().withIdentifier(104)
                                .withIconTintingEnabled(true)
                                .withName("Phone")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_phone),
                        PrimaryDrawerItem().withIdentifier(105)
                                .withIconTintingEnabled(true)
                                .withName("Bookmarks")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_favorites),
                        PrimaryDrawerItem().withIdentifier(106)
                                .withIconTintingEnabled(true)
                                .withName("Settings")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_settings),
                        PrimaryDrawerItem().withIdentifier(107)
                                .withIconTintingEnabled(true)
                                .withName("Create Groups")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_create_groups),
                        DividerDrawerItem(),
                        PrimaryDrawerItem().withIdentifier(108)
                                .withIconTintingEnabled(true)
                                .withName("Invite")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_invate),
                        PrimaryDrawerItem().withIdentifier(109)
                                .withIconTintingEnabled(true)
                                .withName("Help")
                                .withSelectable(false)
                                .withIcon(R.drawable.ic_menu_help)
                ).withOnDrawerItemClickListener(object :Drawer.OnDrawerItemClickListener{
                    override fun onItemClick(
                            view: View?,
                            position: Int,
                            drawerItem: IDrawerItem<*>
                    ): Boolean {
                        Toast.makeText(applicationContext,position.toString(),Toast.LENGTH_SHORT).show()
                        return false
                    }
                }).build()

    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        ProfileDrawerItem().withName("lambiengcode")
                                .withEmail("+84989917877")
                ).build()
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
    }
}