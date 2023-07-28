impl Solution {
    pub fn entity_parser(text: String) -> String {
        
        let mut result = String::new();
        let mut text = text.chars();
        while let Some(c) = text.next() {
            if c == '&' {
                if let Some(c) = text.next() {
                    if c == 'a' {
                        if let Some(c) = text.next() {
                            if c == 'm' {
                                if let Some(c) = text.next() {
                                    if c == 'p' {
                                        if let Some(c) = text.next() {
                                            if c == ';' {
                                                result.push('&');
                                            } else {
                                                result.push_str("&amp");
                                                result.push(c);
                                            }
                                        }
                                    } else {
                                        result.push_str("&am");
                                        result.push(c);
                                    }
                                }
                            } else if c == 'p' {
                                if let Some(c) = text.next() {
                                    if c == 'o' {
                                        if let Some(c) = text.next() {
                                            if c == 's' {
                                                if let Some(c) = text.next() {
                                                    if c == ';' {
                                                        result.push('\'');
                                                    } else {
                                                        result.push_str("&apos");
                                                        result.push(c);
                                                    }
                                                }
                                            } else {
                                                result.push_str("&ap");
                                                result.push(c);
                                            }
                                        }
                                    } else {
                                        result.push_str("&a");
                                        result.push(c);
                                    }
                                }
                            } else {
                                result.push_str("&a");
                                result.push(c);
                            }
                        }
                    } else if c == 'g' {
                        if let Some(c) = text.next() {
                            if c == 't' {
                                if let Some(c) = text.next() {
                                    if c == ';' {
                                        result.push('>');
                                    } else {
                                        result.push_str("&gt");
                                        result.push(c);
                                    }
                                }
                            } else {
                                result.push_str("&g");
                                result.push(c);
                            }
                        }
                    } else if c == 'l' {
                        if let Some(c) = text.next() {
                            if c == 't' {
                                if let Some(c) = text.next() {
                                    if c == ';' {
                                        result.push('<');
                                    } else {
                                        result.push_str("&lt");
                                        result.push(c);
                                    }
                                }
                            } else {
                                result.push_str("&l");
                                result.push(c);
                            }
                        }
                    } else if c == 'q' {
                        if let
    }
}