impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack: Vec<i32> = Vec::new();
        for asteroid in asteroids {
            if asteroid > 0 {
                stack.push(asteroid);
            } else {
                let mut flag = true;
                while stack.len() > 0 {
                    let top = stack.pop().unwrap();
                    if top < 0 {
                        stack.push(top);
                        stack.push(asteroid);
                        flag = false;
                        break;
                    } else if top > -asteroid {
                        stack.push(top);
                        flag = false;
                        break;
                    } else if top == -asteroid {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    stack.push(asteroid);
                }
            }
        }
        stack
    }
}