impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut max = -1;
        for i in 0..4 {
            for j in 0..4 {
                for k in 0..4 {
                    if i == j || i == k || j == k {
                        continue;
                    }
                    let l = 6 - i - j - k;
                    let hour = arr[i] * 10 + arr[j];
                    let min = arr[k] * 10 + arr[l];
                    if hour < 24 && min < 60 {
                        max = max.max(hour * 60 + min);
                    }
                }
            }
        }
        if max == -1 {
            return "".to_string();
        }
        format!("{:02}:{:02}", max / 60, max % 60)
    }
}