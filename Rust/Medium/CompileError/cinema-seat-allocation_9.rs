impl Solution {
    pub fn max_number_of_families(n: i32, reserved_seats: Vec<Vec<i32>>) -> i32 {
        
        let mut rsv = reserved_seats;
        rsv.sort();
        let mut ans = 0;
        let mut last = 0;
        let mut cnt = 0;
        for i in 0..rsv.len() {
            if rsv[i][0] != last {
                ans += cnt / 4;
                cnt = 0;
                last = rsv[i][0];
            }
            let mut j = i;
            while j < rsv.len() && rsv[j][0] == last {
                j += 1;
            }
            let mut state = 0;
            for k in i..j {
                if rsv[k][1] == 2 || rsv[k][1] == 3 || rsv[k][1] == 4 || rsv[k][1] == 5 {
                    state |= 1;
                } else if rsv[k][1] == 6 || rsv[k][1] == 7 || rsv[k][1] == 8 || rsv[k][1] == 9 {
                    state |= 2;
                } else {
                    state |= 3;
                }
            }
            if state == 1 {
                cnt += 2;
            } else if state == 2 {
                cnt += 2;
            } else if state == 0 {
                cnt += 4;
            }
            i = j - 1;
        }
        ans += cnt / 4;
        ans += (n - rsv.len() as i32) * 2;
        ans
    }
}