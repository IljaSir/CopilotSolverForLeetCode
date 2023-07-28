impl Solution {
    pub fn longest_substring(s: String, k: i32) -> i32 {
        

        let mut max = 0;
        for i in 1..=26 {
            let mut left = 0;
            let mut right = 0;
            let mut count = 0;
            let mut map = vec![0; 26];
            while right < s.len() {
                if map[(s.as_bytes()[right] - b'a') as usize] == 0 {
                    count += 1;
                }
                map[(s.as_bytes()[right] - b'a') as usize] += 1;
                while count > i {
                    map[(s.as_bytes()[left] - b'a') as usize] -= 1;
                    if map[(s.as_bytes()[left] - b'a') as usize] == 0 {
                        count -= 1;
                    }
                    left += 1;
                }
                if count == i {
                    let mut valid = true;
                    for j in 0..26 {
                        if map[j] > 0 && map[j] < k {
                            valid = false;
                            break;
                        }
                    }
                    if valid {
                        max = max.max(right - left + 1);
                    }
                }
                right += 1;
            }
        }
        max as i32
    }
}