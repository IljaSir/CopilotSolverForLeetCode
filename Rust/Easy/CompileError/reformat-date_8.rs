impl Solution {
    pub fn reformat_date(date: String) -> String {
        
        let mut month = String::new();
        let mut day = String::new();
        let mut year = String::new();
        let mut month_num = 0;
        let mut day_num = 0;
        let mut year_num = 0;
        let mut start = 0;
        let mut end = 0;
        let mut i = 0;
        for c in date.chars() {
            if c >= '0' && c <= '9' {
                if start == 0 {
                    start = i;
                }
                end = i;
            } else if c >= 'a' && c <= 'z' {
                if start == 0 {
                    start = i;
                }
                end = i;
            } else if c >= 'A' && c <= 'Z' {
                if start == 0 {
                    start = i;
                }
                end = i;
            }
            i += 1;
        }
        day = date[start..=end].to_string();
        //println!("{}", day);
        start = 0;
        end = 0;
        i = 0;
        for c in date.chars() {
            if c >= '0' && c <= '9' {
                if start == 0 {
                    start = i;
                }
                end = i;
            } else if c >= 'a' && c <= 'z' {
                if start == 0 {
                    start = i;
                }
                end = i;
            } else if c >= 'A' && c <= 'Z' {
                if start == 0 {
                    start = i;
                }
                end = i;
            }
            i += 1;
        }
        month = date[start..=end].to_string();
        //println!("{}", month);
        start = 0;
        end = 0;
        i = 0;
        for c in date.chars() {
            if c >= '0' && c <= '9' {
                if start == 0 {
                    start = i;
                }
                end = i;
            } else if c >= 'a' && c <= 'z' {
                if start == 0 {
                    start = i;
                }
                end = i;
            } else if c >= 'A' && c <= 'Z' {
                if start == 0 {
                    start = i;
                }
    }
}