impl Solution {
    pub fn kth_palindrome(queries: Vec<i32>, int_length: i32) -> Vec<i64> {
        
        let mut result = Vec::new();
        for i in queries {
            let mut tmp = i.to_string();
            while tmp.len() < int_length as usize {
                tmp = format!("0{}", tmp);
            }
            let mut tmp = tmp.chars().collect::<Vec<char>>();
            let mut left = 0;
            let mut right = tmp.len() - 1;
            while left < right {
                tmp[right] = tmp[left];
                left += 1;
                right -= 1;
            }
            let mut tmp = tmp.iter().collect::<String>();
            let mut tmp = tmp.parse::<i64>().unwrap();
            if tmp < i as i64 {
                tmp += 1;
            }
            let mut tmp = tmp.to_string();
            while tmp.len() < int_length as usize {
                tmp = format!("0{}", tmp);
            }
            let mut tmp = tmp.chars().collect::<Vec<char>>();
            let mut left = 0;
            let mut right = tmp.len() - 1;
            while left < right {
                tmp[right] = tmp[left];
                left += 1;
                right -= 1;
            }
            let mut tmp = tmp.iter().collect::<String>();
            let mut tmp = tmp.parse::<i64>().unwrap();
            if tmp < i as i64 {
                tmp += 1;
            }
            let mut tmp = tmp.to_string();
            while tmp.len() < int_length as usize {
                tmp = format!("0{}", tmp);
            }
            let mut tmp = tmp.chars().collect::<Vec<char>>();
            let mut left = 0;
            let mut right = tmp.len() - 1;
            while left < right {
                tmp[right] = tmp[left];
                left += 1;
                right -= 1;
            }
            let mut tmp = tmp.iter().collect::<String>();
            let mut tmp = tmp.parse::<i64>().unwrap();
            if tmp < i as i64 {
                tmp += 1;
            }
            result.push(tmp);
        }
        result
    }
}