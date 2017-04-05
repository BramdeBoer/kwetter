import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { LoginComponent } from './login/login.component';

const appRoutes: Routes = [
  {
    component: HomeComponent,
    path: '',
  },
  {
    component: ProfileComponent,
    path: 'profile'
  },
  {
    component: LoginComponent,
    path: 'login'
  }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);
