impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        for asteroid in asteroids {
            if asteroid > 0 {
                stack.push(asteroid);
            } else {
                while !stack.is_empty() && stack[stack.len() - 1] > 0 && stack[stack.len() - 1] < -asteroid {
                    stack.pop();
                }
                if stack.is_empty() || stack[stack.len() - 1] < 0 {
                    stack.push(asteroid);
                } else if stack[stack.len() - 1] == -asteroid {
                    stack.pop();
                }
            }
        }
        stack
    }
}