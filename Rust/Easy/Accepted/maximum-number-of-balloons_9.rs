impl Solution {
    pub fn max_number_of_balloons(text: String) -> i32 {
        
        let mut dict: Vec<i32> = vec![0; 26];
        for c in text.chars() {
            dict[c as usize - 'a' as usize] += 1;
        }
        let mut count = 0;
        let mut flag = true;
        while flag {
            for c in "balloon".chars() {
                if dict[c as usize - 'a' as usize] > 0 {
                    dict[c as usize - 'a' as usize] -= 1;
                } else {
                    flag = false;
                    break;
                }
            }
            if flag {
                count += 1;
            }
        }
        count
    }
}