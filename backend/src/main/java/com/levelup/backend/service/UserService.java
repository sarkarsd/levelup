package com.levelup.backend.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Calculates the level based on XP
    public int calculateLevel(int xp) {
        int level = 0;
        int threshold = 100; // XP needed to go from level 0 to level 1

        // Keep checking if XP is enough to cross current threshold
        while (xp >= threshold) {
            xp -= threshold;   // Subtract current level's XP requirement
            level++;           // Level up
            threshold *= 2;    // XP needed for next level doubles
        }

        return level;
    }


}
