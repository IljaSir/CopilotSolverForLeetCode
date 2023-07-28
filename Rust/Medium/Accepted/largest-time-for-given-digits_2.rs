impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut arr = arr;
        arr.sort();
        arr.reverse();
        for i in 0..4 {
            for j in 0..4 {
                if i != j {
                    for k in 0..4 {
                        if i != k && j != k {
                            let l = 6 - i - j - k;
                            let hour = arr[i] * 10 + arr[j];
                            let minute = arr[k] * 10 + arr[l];
                            if hour < 24 && minute < 60 {
                                return format!("{}{}:{}{}", arr[i], arr[j], arr[k], arr[l]);
                            }
                        }
                    }
                }
            }
        }
        String::new()
    }
}