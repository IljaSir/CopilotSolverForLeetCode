impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::with_capacity(asteroids.len());
        for asteroid in asteroids {
            if asteroid > 0 {
                stack.push(asteroid);
            } else {
                let mut exploded = false;
                while let Some(&top) = stack.last() {
                    if top < 0 {
                        stack.push(asteroid);
                        break;
                    } else if top == -asteroid {
                        stack.pop();
                        exploded = true;
                        break;
                    } else if top > -asteroid {
                        exploded = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if !exploded && stack.is_empty() {
                    stack.push(asteroid);
                }
            }
        }
        stack
    }
}