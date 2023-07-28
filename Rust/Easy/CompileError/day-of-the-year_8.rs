impl Solution {
    pub fn day_of_year(date: String) -> i32 {
        
        let mut ans = 0;
        let mut month = 0;
        let mut year = 0;
        let mut day = 0;
        let mut is_leap = false;
        let mut day_of_month = vec![31,28,31,30,31,30,31,31,30,31,30,31];
        for i in date.chars() {
            if i == '-' {
                if month == 0 {
                    month = ans;
                    ans = 0;
                } else {
                    year = ans;
                    ans = 0;
                }
            } else {
                ans = ans * 10 + (i as i32 - '0' as i32);
            }
        }
        day = ans;
        if year % 4 == 0 {
            if year % 100 == 0 {
                if year % 400 == 0 {
                    is_leap = true;
                }
            } else {
                is_leap = true;
            }
        }
        if is_leap {
            day_of_month[1] = 29;
        }
        ans = 0;
        for i in 0..month-1 {
            ans += day_of_month[i];
        }
        ans += day;
        ans
    }
}