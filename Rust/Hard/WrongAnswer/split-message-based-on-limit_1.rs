impl Solution {
    pub fn split_message(message: String, limit: i32) -> Vec<String> {
        
        let mut result = vec![];
        let mut message = message;
        let mut index = 1;
        let mut limit = limit as usize;
        let mut len = message.len();
        while len > 0 {
            if len < limit {
                limit = len;
            }
            let mut part = String::from(&message[..limit]);
            part.push_str(&format!("<{}/{}>", index, (len as f32 / limit as f32).ceil() as i32));
            result.push(part);
            message = String::from(&message[limit..]);
            len = message.len();
            index += 1;
        }
        result
    }
}