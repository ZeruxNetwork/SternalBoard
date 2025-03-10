package com.xism4.sternalboard;

import com.xism4.sternalboard.managers.ScoreboardManager;
import com.xism4.sternalboard.managers.animation.AnimationManager;
import org.bukkit.configuration.file.YamlConfiguration;

public class Structure extends SetupManager {

    private static Structure instance;

    public static Structure getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        commandHandler(this);
        loadTabCompletions();
        loadConfig();
        loadScoreboardMgr(this);
        eventHandler(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling SternalBoard");
        instance = null;
        scoreboardManager = null;
    }

    public ScoreboardManager getScoreboardManager() {
        return this.scoreboardManager;
    }

    public AnimationManager getAnimationManager() {
        return this.animationManager;
    }

    public boolean isAnimationEnabled() {
        return this.animateScoreboard;
    }

    public YamlConfiguration getAnimConfig() {
        return this.animConfig;
    }
}
