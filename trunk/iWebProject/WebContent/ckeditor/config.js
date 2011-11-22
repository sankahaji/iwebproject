/*
 * Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	config.language = 'zh-cn'; // 配置语言

	config.uiColor = '#FFF'; // 背景颜色

	config.width = '720px'; // 宽度

	config.height = '220px'; // 高度

	config.skin = 'office2003';// 界面v2,kama,office2003

	config.toolbar = 'Full';// 工具栏风格Full,Basic

	config.resize_enabled = false;// 输入框是否能被拉大
	
	config.toolbarCanCollapse = false;//工具栏是否能被收缩
	
    config.disableNativeSpellChecker = false;
    
    config.scayt_autoStartup = false;
    
    config.startupFocus = true;

	config.font_names = '宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'
			+ config.font_names;
	config.font_defaultLabel = '宋体';
	config.fontSize_sizes = '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;';
	config.fontSize_defaultLabel = '12';

	// 编辑器中回车产生的标签
	config.enterMode = CKEDITOR.ENTER_BR; // 可选：CKEDITOR.ENTER_P或CKEDITOR.ENTER_DIV

	config.toolbar = [
			['Font', 'FontSize', 'Bold', 'Italic', 'Underline', 'TextColor','BGColor'],
			['JustifyLeft', 'JustifyCenter', 'JustifyRight'],['Image']
	];

};
