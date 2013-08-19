if (app.documents.length != 0) {  
    var doc = app.activeDocument; 
    var folder = Folder('~/Desktop').selectDlg();
    var colors  = doc.layerSets.getByName("Colors");
    var overlay = doc.layerSets.getByName("Overlay");
    var bars  = overlay.layers.getByName("Bars");
    var multi  = overlay.layers.getByName("Multi");
    var states = doc.layerSets.getByName("States");
    var debug =  doc.layerSets.getByName("Debug");
    
    states.layers.getByName("On").visible = true;
    states.layers.getByName("Off").visible = true;
    multi.visible = false;
    
    bars.visible = false;
    runColors("blockLumaLampOff"); 
    bars.visible = true;
    runColors("blockLumaLampBarsOff"); 
    
    states.layers.getByName("Off").visible = false;
    
    bars.visible = false;
    runColors("blockLumaLampOn"); 
    bars.visible = true;
    runColors("blockLumaLampBarsOn"); 
    
    multi.visible = true;
    bars.visible = false;
    runColors("blockMultiLampOn"); 
    bars.visible = true;
    runColors("blockMultiLampBarsOn"); 
    
}

function runColors(name) {
    disableAllColors();
    debug.layers.getByName("0").visible = true;
    save(name+"_0");
    for (i = 1; i < 16; i++) {
        disableAllColors();
        colors.layers.getByName(i.toString()).visible = true;
        debug.layers.getByName(i.toString()).visible = true;
        save(name+"_"+i);
    }   
}

function save(name) {
    var saveFile = File(folder + "/" + name + ".png");
    if(saveFile.exists){
        saveFile.remove();
    }
    SaveForWeb(saveFile);
}

function SaveForWeb(saveFile) {
    var sfwOptions = new ExportOptionsSaveForWeb(); 
    sfwOptions.format = SaveDocumentType.PNG; 
    sfwOptions.optimized = true; 
    sfwOptions.transparency = true;
    sfwOptions.PNG8 = false;
    
    activeDocument.exportDocument(saveFile, ExportType.SAVEFORWEB, sfwOptions);
}


function disableAllColors() {
    debug.layers.getByName("0").visible = false;
    for (n=1; n<16; n++) {
        colors.layers.getByName(n.toString()).visible = false;
        debug.layers.getByName(n.toString()).visible = false;
    }
}