impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut arr = arr;
        arr.sort();
        let mut time = String::new();
        let mut i = 3;
        while i >= 0 {
            if arr[i] <= 2 {
                time.push((arr[i] + 48) as u8 as char);
                let mut j = 3;
                while j >= 0 {
                    if j == i {
                        j -= 1;
                        continue;
                    }
                    if arr[i] == 2 && arr[j] >= 4 {
                        j -= 1;
                        continue;
                    }
                    time.push((arr[j] + 48) as u8 as char);
                    time.push(':');
                    let mut k = 3;
                    while k >= 0 {
                        if k == i || k == j {
                            k -= 1;
                            continue;
                        }
                        time.push((arr[k] + 48) as u8 as char);
                        let mut l = 3;
                        while l >= 0 {
                            if l == i || l == j || l == k {
                                l -= 1;
                                continue;
                            }
                            time.push((arr[l] + 48) as u8 as char);
                            return time;
                        }
                    }
                }
            }
            i -= 1;
        }
        time
    }
}