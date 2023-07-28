impl Solution {
    pub fn largest_time_from_digits(arr: Vec<i32>) -> String {
        
        let mut max = -1;
        let mut max_i = 0;
        let mut max_j = 1;
        let mut max_k = 2;
        let mut max_l = 3;
        for i in 0..4 {
            for j in 0..4 {
                for k in 0..4 {
                    for l in 0..4 {
                        if i == j || i == k || i == l || j == k || j == l || k == l {
                            continue;
                        }
                        let hh = arr[i] * 10 + arr[j];
                        let mm = arr[k] * 10 + arr[l];
                        if hh < 24 && mm < 60 {
                            let time = hh * 60 + mm;
                            if time > max {
                                max = time;
                                max_i = i;
                                max_j = j;
                                max_k = k;
                                max_l = l;
                            }
                        }
                    }
                }
            }
        }
        if max == -1 {
            String::from("")
        } else {
            format!("{:02}:{:02}", arr[max_i] * 10 + arr[max_j], arr[max_k] * 10 + arr[max_l])
        }
    }
}