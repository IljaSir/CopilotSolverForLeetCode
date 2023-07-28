impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        for asteroid in asteroids {
            if asteroid > 0 {
                stack.push(asteroid);
            } else {
                while let Some(top) = stack.last() {
                    if *top > 0 && -*top < asteroid {
                        break;
                    }
                    if *top > 0 && -*top > asteroid {
                        stack.pop();
                        continue;
                    }
                    if *top > 0 && -*top == asteroid {
                        stack.pop();
                    }
                    break;
                }
                if stack.is_empty() || *stack.last().unwrap() < 0 {
                    stack.push(asteroid);
                }
            }
        }
        stack
    }
}