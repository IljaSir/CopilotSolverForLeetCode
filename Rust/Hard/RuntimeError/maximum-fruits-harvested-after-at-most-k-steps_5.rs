impl Solution {
    pub fn max_total_fruits(fruits: Vec<Vec<i32>>, start_pos: i32, k: i32) -> i32 {
        
        let mut cur = 0;
        let mut max = 0;
        let mut left = start_pos;
        let mut right = start_pos;
        let mut left_fruit = fruits[start_pos as usize][1];
        let mut right_fruit = fruits[start_pos as usize][1];
        let mut left_fruit_count = 1;
        let mut right_fruit_count = 1;
        while left >= 0 || right < fruits.len() as i32 {
            if left >= 0 && (right >= fruits.len() as i32 || left_fruit_count <= right_fruit_count) {
                left -= 1;
                if left >= 0 {
                    if left_fruit == fruits[left as usize][1] {
                        left_fruit_count += 1;
                    } else {
                        left_fruit_count = 1;
                        left_fruit = fruits[left as usize][1];
                    }
                    cur += left_fruit;
                }
            } else {
                right += 1;
                if right < fruits.len() as i32 {
                    if right_fruit == fruits[right as usize][1] {
                        right_fruit_count += 1;
                    } else {
                        right_fruit_count = 1;
                        right_fruit = fruits[right as usize][1];
                    }
                    cur += right_fruit;
                }
            }
            if left + k + 1 >= right {
                max = max.max(cur);
            } else {
                cur -= fruits[left as usize + 1][1];
                left_fruit_count -= 1;
                if left_fruit_count == 0 {
                    left_fruit = fruits[left as usize + 2][1];
                    left_fruit_count = 1;
                }
            }
        }
        max
    }
}