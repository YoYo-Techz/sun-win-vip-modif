import { ISidebarModel } from '../model/sidebar.model';

export const SIDE_BAR: ISidebarModel[] = [
  // roles: 0-Admin; 1-USER; 2-MKT; 3-CS
  {
    id: 'admin-menu',
    title: 'Administration',
    translate: 'global.menu.admin.main',
    icon: 'user-plus',
    routerLink: 'javascript:void(0);',
    collapsed: true,
    subMenu: [
      {
        id: 'user-tracker',
        title: 'User tracker',
        translate: 'global.menu.admin.tracker',
        icon: 'eye',
        routerLink: 'admin/tracker',
        roles: [0],
      },
      {
        id: 'metrics',
        title: 'Metrics',
        translate: 'global.menu.admin.metrics',
        icon: 'tachometer-alt',
        routerLink: 'admin/metrics',
        roles: [0],
      },
      {
        id: 'health',
        title: 'Health',
        translate: 'global.menu.admin.health',
        icon: 'heart',
        routerLink: 'admin/health',
        roles: [0],
      },
      {
        id: 'configuration',
        title: 'Configuration',
        translate: 'global.menu.admin.configuration',
        icon: 'list',
        routerLink: 'admin/configuration',
        roles: [0],
      },
      {
        id: 'audits',
        title: 'Audits',
        translate: 'global.menu.admin.audits',
        icon: 'bell',
        routerLink: 'admin/audits',
        roles: [0],
      },
      {
        id: 'logs',
        title: 'Logs',
        translate: 'global.menu.admin.logs',
        icon: 'tasks',
        routerLink: 'admin/logs',
        roles: [0],
      },
      {
        id: 'api',
        title: 'API',
        translate: 'global.menu.admin.apidocs',
        icon: 'book',
        routerLink: 'admin/docs',
        roles: [0],
      },
    ],
  },
  {
    id: 'entity-menu',
    title: 'Entities',
    translate: 'global.menu.entities.main',
    icon: 'th-list',
    routerLink: 'javascript:void(0);',
    collapsed: false,
    subMenu: [
      {
        id: 'user-management',
        title: 'Admin user management',
        translate: 'global.menu.entities.admin-user-management',
        icon: 'user',
        routerLink: 'admin-user-management',
        roles: [0],
      },
      {
        id: 'system-config',
        title: 'System configuration',
        translate: 'global.menu.admin.system-config',
        icon: 'wrench',
        routerLink: 'system-config',
        roles: [0, 2, 3],
      },
      // {
      //   title: 'Taixiu User',
      //   translate: 'global.menu.entities.taixiuUser',
      //   icon: 'user',
      //   routerLink: 'admin/user-management',
      //   roles: [0],
      // },
      // {
      //   title: 'Taixiu',
      //   translate: 'global.menu.entities.taixiu',
      //   icon: 'asterisk',
      //   routerLink: 'taixiu',
      //   roles: [0],
      // },
      // {
      //   title: 'Taixiu Record',
      //   translate: 'global.menu.entities.taixiuRecord',
      //   icon: 'asterisk',
      //   routerLink: 'taixiu-record',
      //   roles: [0],
      // },

      // {
      //   title: 'Userinfo',
      //   translate: 'global.menu.entities.userinfo',
      //   icon: 'asterisk',
      //   routerLink: 'userinfo',
      //   roles: [0],
      // },
      // {
      //   title: 'Chatbox',
      //   translate: 'global.menu.entities.chatbox',
      //   icon: 'asterisk',
      //   routerLink: 'chatbox',
      //   roles: [0, 2, 3],
      // },
      // {
      //   title: 'Taixiu rank',
      //   translate: 'global.menu.entities.txRank',
      //   icon: 'asterisk',
      //   routerLink: 'tx-rank',
      //   roles: [0, 2, 3],
      // },
      // {
      //   title: 'Rocket',
      //   translate: 'global.menu.entities.rocket',
      //   icon: 'asterisk',
      //   routerLink: 'rocket',
      //   roles: [0],
      // },
      // {
      //   title: 'Rocket rank',
      //   translate: 'global.menu.entities.rocketRank',
      //   icon: 'asterisk',
      //   routerLink: 'rocket-rank',
      //   roles: [0, 2, 3],
      // },
      // {
      //   title: 'Rocket chatbox',
      //   translate: 'global.menu.entities.rocketChatbox',
      //   icon: 'asterisk',
      //   routerLink: 'rocket-chatbox',
      //   roles: [0, 2, 3],
      // },
      {
        id: 'tai-xiu',
        title: 'Player management',
        translate: 'global.menu.entities.taixiuUser',
        icon: 'user',
        routerLink: 'admin/user-management',
        roles: [0],
      },
      {
        id: 'transfer-history',
        title: 'Transfer detail',
        translate: '',
        icon: 'list',
        routerLink: 'transfer-history',
        roles: [0, 2, 3],
      },
      {
        id: 'transaction-history',
        title: 'Transaction detail',
        translate: '',
        icon: 'list',
        routerLink: 'transaction-history',
        roles: [0, 2, 3],
      },
      {
        id: 'report-game',
        title: 'Report Game',
        translate: '',
        icon: 'list',
        routerLink: 'report-game',
        roles: [0, 2, 3],
      },
      {
        id: 'tai-xiu',
        title: 'Over/under',
        translate: 'global.menu.entities.taixiu',
        icon: 'gamepad',
        routerLink: '',
        roles: [0, 2, 3],
        collapsed: false,
        subMenu2: [
          // {
          //   title: 'Taixiu User',
          //   translate: 'global.menu.entities.taixiuUser',
          //   icon: 'user',
          //   routerLink: 'admin/user-management',
          //   roles: [0],
          // },
          {
            title: 'Taixiu',
            translate: 'global.menu.entities.taixiuHistory',
            icon: 'asterisk',
            routerLink: 'taixiu',
            roles: [0],
          },
          {
            title: 'Taixiu Record',
            translate: 'global.menu.entities.taixiuRecord',
            icon: 'asterisk',
            routerLink: 'taixiu-record',
            roles: [0],
          },
          {
            title: 'Userinfo',
            translate: 'global.menu.entities.userinfo',
            icon: 'asterisk',
            routerLink: 'userinfo',
            roles: [0],
          },
          {
            title: 'Chatbox',
            translate: 'global.menu.entities.chatbox',
            icon: 'asterisk',
            routerLink: 'chatbox',
            roles: [0, 2, 3],
          },
          {
            title: 'Taixiu rank',
            translate: 'global.menu.entities.txRank',
            icon: 'asterisk',
            routerLink: 'tx-rank',
            roles: [0, 2, 3],
          },
        ],
      },
      {
        id: 'rocket',
        title: 'Trên Dưới',
        translate: 'global.menu.entities.rocket',
        icon: 'gamepad',
        routerLink: '',
        roles: [0, 2, 3],
        collapsed: false,
        subMenu2: [
          {
            title: 'Rocket',
            translate: 'global.menu.entities.rocketHistory',
            icon: 'asterisk',
            routerLink: 'rocket',
            roles: [0],
          },
          {
            title: 'Rocket rank',
            translate: 'global.menu.entities.rocketRank',
            icon: 'asterisk',
            routerLink: 'rocket-rank',
            roles: [0, 2, 3],
          },
          {
            title: 'Rocket chatbox',
            translate: 'global.menu.entities.rocketChatbox',
            icon: 'asterisk',
            routerLink: 'rocket-chatbox',
            roles: [0, 2, 3],
          },
          {
            title: 'Rocket rate',
            translate: 'global.menu.entities.rocketRate',
            icon: 'asterisk',
            routerLink: 'rocket-rate',
            roles: [0, 2, 3],
          },
        ],
      },
      {
        id: 'xocdia',
        title: 'Xóc Đĩa',
        translate: 'global.menu.entities.xocdia',
        icon: 'gamepad',
        routerLink: '',
        roles: [0, 2, 3],
        collapsed: false,
        subMenu2: [
          // {
          //   title: 'Xocdia User',
          //   translate: 'global.menu.entities.xocdiaUser',
          //   icon: 'user',
          //   routerLink: 'admin/user-management',
          //   roles: [0],
          // },
          {
            title: 'Xocdia',
            translate: 'global.menu.entities.xocdiaHistory',
            icon: 'asterisk',
            routerLink: 'xocdia',
            roles: [0],
          },
          {
            title: 'Xocdia Record',
            translate: 'global.menu.entities.xocdiaRecord',
            icon: 'asterisk',
            routerLink: 'xocdia-record',
            roles: [0],
          },
          // {
          //   title: 'Userinfo',
          //   translate: 'global.menu.entities.userinfo',
          //   icon: 'asterisk',
          //   routerLink: 'userinfo',
          //   roles: [0],
          // },
          {
            title: 'Chatbox',
            translate: 'global.menu.entities.xocdiaChatbox',
            icon: 'asterisk',
            routerLink: 'xocdia-chatbox',
            roles: [0, 2, 3],
          },
          {
            title: 'Xocdia rank',
            translate: 'global.menu.entities.xocdiaRank',
            icon: 'asterisk',
            routerLink: 'xocdia-rank',
            roles: [0, 2, 3],
          },
          {
            title: 'Xocdia jackpot record',
            translate: 'global.menu.entities.xocdiaJackpotRecord',
            icon: 'asterisk',
            routerLink: 'xocdia-jackpot-record',
            roles: [0],
          },
          {
            title: 'Jackpot setting record',
            translate: 'global.menu.entities.jackpotSettingRecord',
            icon: 'asterisk',
            routerLink: 'jackpot-setting-record',
            roles: [0],
          },
        ],
      },
    ],
  },
];
