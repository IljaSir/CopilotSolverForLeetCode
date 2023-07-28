impl Solution {
    pub fn asteroid_collision(asteroids: Vec<i32>) -> Vec<i32> {
        
        let mut stack = Vec::new();
        for i in asteroids {
            if i > 0 {
                stack.push(i);
            } else {
                let mut flag = true;
                while let Some(j) = stack.pop() {
                    if j > -i {
                        stack.push(j);
                        flag = false;
                        break;
                    } else if j == -i {
                        flag = false;
                        break;
                    }
                }
                if flag {
                    stack.push(i);
                }
            }
        }
        stack
    }
}